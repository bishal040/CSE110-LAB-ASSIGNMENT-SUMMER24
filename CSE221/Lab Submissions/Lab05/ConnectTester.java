public class ConnectTester{
  public static void main(String[] args) {
    ConnectFriends sanaf = new ConnectFriends("Sanaf");
    System.out.println("=======1=======");
    ConnectFriends mantasha = new ConnectFriends("Mantasha", 3);
    ConnectFriends mostafiz = new ConnectFriends("Mostafiz");
    ConnectFriends matt = new ConnectFriends("Matt", 4);
    System.out.println("=======2=======");
    sanaf.sendFriendRequest(mantasha);
    System.out.println("=======3=======");
    sanaf.sendFriendRequest(mostafiz, matt);
    System.out.println("=======4=======");
    sanaf.showDetails();
    System.out.println("=======5=======");
    sanaf.removeRequest("Mantasha");
    System.out.println("=======6=======");
    sanaf.showDetails();
    System.out.println("=======7=======");
    sanaf.removeRequest("Murdock");
    System.out.println("=======8=======");
    sanaf.removeRequest("Matt");
    sanaf.removeRequest("Mostafiz");
    sanaf.showDetails();
    System.out.println("=======9=======");
    mantasha.showDetails();
  }
}

