package org.home.huawei.new3;

import java.util.*;

public class Main {

    public static Set<Command> allCommands = new HashSet<>();
    public static HashMap<Command,String> commandRes = new HashMap<>();
    public static Command start = new Command(Sources.RmApp, Event.start);


    public static void main(String[] args) {
        Command start = new Command(Sources.RmApp, Event.start);
        Command app_accepted = new Command(Sources.ResouceScheduler,Event.app_accepted);
        Command container_allocated = new Command(Sources.RmContainer, Event.container_allocated);
        Command launched = new Command(Sources.ApplicationMasterLauncher, Event.launched);
        Command finished = new Command(Sources.ResouceScheduler, Event.finished);
        Command kill = new Command(Sources.RmApp, Event.kill);
        allCommands.add(start);
        allCommands.add(app_accepted);
        allCommands.add(container_allocated);
        allCommands.add(launched);
        allCommands.add(finished);
        allCommands.add(kill);
        commandRes.put(start, Status.submitted);
        commandRes.put(app_accepted, Status.scheduled);
        commandRes.put(container_allocated, Status.allocated);
        commandRes.put(launched, Status.running);
        commandRes.put(finished, Status.finished);
        commandRes.put(kill, Status.killed);
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(calStatic(s));
    }

    private static String calStatic(String s) {
        HashMap<String,RmAppAttempt> rmSet = new HashMap<>();
        String[] allCommand = s.split(" ");
        List<String> res = new ArrayList<>();
        for (String command : allCommand) {
            String[] eles = command.split("\\|");
            if (eles.length != 3)
                continue;
            String sur = eles[0];
            String app = eles[1];
            String env = eles[2];
            Command c = new Command(sur, env);
            if (allCommands.contains(c)){
                if (c.equals(start)){
                    if (rmSet.containsKey(app))
                        continue;
                    RmAppAttempt rmAppAttempt = new RmAppAttempt(app, Status.submitted);
                    rmSet.put(rmAppAttempt.getName(),rmAppAttempt);
                    res.add(rmAppAttempt.toString());
                } else {
                    if (rmSet.containsKey(app)){
                        RmAppAttempt appAttempt = rmSet.get(app);
                        if (c.getEnv().equals(Event.app_accepted) && appAttempt.getStatus().equals(Status.submitted)){
                            appAttempt.setStatus(commandRes.get(c));
                            res.add(appAttempt.toString());
                        } else if (c.getEnv().equals(Event.container_allocated) && appAttempt.getStatus().equals(Status.scheduled)){
                            appAttempt.setStatus(commandRes.get(c));
                            res.add(appAttempt.toString());
                        } else if (c.getEnv().equals(Event.launched) && appAttempt.getStatus().equals(Status.scheduled)){
                            appAttempt.setStatus(commandRes.get(c));
                            res.add(appAttempt.toString());
                        } else if (c.getEnv().equals(Event.finished) && appAttempt.getStatus().equals(Status.running)){
                            appAttempt.setStatus(commandRes.get(c));
                            res.add(appAttempt.toString());
                        } else if (c.getEnv().equals(Event.kill) && !appAttempt.getStatus().equals(Status.finished)){
                            appAttempt.setStatus(commandRes.get(c));
                            res.add(appAttempt.toString());
                        }
                    }
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (String re : res) {
            ret.append(re);
        }
        return ret.toString();
    }

}


class Command {
    public String getSur() {
        return sur;
    }

    public void setSur(String sur) {
        this.sur = sur;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    private String sur;
    private String env;

    public Command(String sur, String env) {
        this.sur = sur;
        this.env = env;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Command command = (Command) o;
        return sur.equals(command.sur) &&
                env.equals(command.env);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sur, env);
    }
}
class RmAppAttempt {

    private String name;
    private String status;

    @Override
    public String toString() {
        return String.format("%s|%s;",name,status);
    }

    public RmAppAttempt(String name, String status) {
        this.name = name;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RmAppAttempt that = (RmAppAttempt) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RmAppAttempt(String name) {
        this.name = name;
    }
}

class Sources {
    public static String RmApp = "RmApp";
    public static String ResouceScheduler = "ResouceScheduler";
    public static String ApplicationMasterLauncher = "ApplicationMasterLauncher";
    public static String RmContainer = "RmContainer";

}

class Event {
    public static String start = "start";
    public static String app_accepted = "app_accepted";
    public static String container_allocated = "container_allocated";
    public static String launched = "launched";
    public static String finished = "finished";
    public static String kill = "kill";
}

class Status {
    public static String submitted = "submitted";
    public static String scheduled = "scheduled";
    public static String allocated = "allocated";
    public static String running = "running";
    public static String finished = "finished";
    public static String killed = "killed";
}