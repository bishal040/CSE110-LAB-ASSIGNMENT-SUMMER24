public class ConnectFriends {
    private String name;
    private int maxReq;
    private String[] sent;
    private int count;

    public ConnectFriends(String name) {
        this.name = name;
        this.maxReq = 2;
        this.sent = new String[maxReq];
        this.count = 0;
        System.out.println("Welcome to ConnectFriends, " + name);
    }

    public ConnectFriends(String name, int maxReq) {
        this.name = name;
        this.maxReq = maxReq;
        this.sent = new String[maxReq];
        this.count = 0;
        System.out.println("Welcome to ConnectFriends, " + name);
    }

    public void sendFriendRequest(ConnectFriends other) {
        if (count == maxReq) {
            System.out.println(name + " has reached the friend request limit!");
            return;
        }
        sent[count++] = other.name;
        System.out.println(name + " sent a friend request to " + other.name + ".");
    }

    public void sendFriendRequest(ConnectFriends a, ConnectFriends b) {
        sendFriendRequest(a);
        sendFriendRequest(b);
    }

    public void showDetails() {
        System.out.println("User Name: " + name);
        System.out.println("Maximum number of Sent Friend Request: " + maxReq);
        System.out.println("Total Friends Request: " + count);
        System.out.print("Sent Friends Request:");
        if (count == 0) {
            System.out.println();
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(" " + sent[i]);
        }
        System.out.println();
    }

    public void removeRequest(String user) {
        int idx = -1;
        for (int i = 0; i < count; i++) {
            if (sent[i].equals(user)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println(user + " is not in " + name + "'s sent request list.");
            return;
        }
        System.out.println("Request to add " + user + " is removed for " + name + ".");
        for (int i = idx; i < count - 1; i++) {
            sent[i] = sent[i + 1];
        }
        count--;
    }
}