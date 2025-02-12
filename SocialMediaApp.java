import java.util.HashSet;
// Friend Node Class (For storing friend IDs)
class FriendNode {
    int friendID;
    FriendNode next;
    public FriendNode(int friendID) {
        this.friendID = friendID;
        this.next = null;
    }
}
// User Node Class
class UserNode {
    int userID;
    String name;
    int age;
    FriendNode friendList;//each user has corresponding friends linked list
    UserNode next;
    public UserNode(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}
// Social Media Friend Connections Management
class SocialMediaNetwork {
    private UserNode head;
    // Add a new user
    public void addUser(int userID, String name, int age) {
        UserNode newUser = new UserNode(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }
    // Find user by ID
    private UserNode findUser(int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    // Add a friend connection
    public void addFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }
        addFriendToList(user1, userID2);
        addFriendToList(user2, userID1);
    }
    // Helper function to add a friend to a user's friend list
    private void addFriendToList(UserNode user, int friendID) {
        FriendNode newFriend = new FriendNode(friendID);
        if (user.friendList == null) {
            user.friendList = newFriend;
        } else {
            FriendNode temp = user.friendList;
            while (temp.next != null) {
                if (temp.friendID == friendID) return; // Avoid duplicate friendships it means this friend already exist in users friend list
                temp = temp.next;
            }
            temp.next = newFriend;
        }
    }
    // Remove a friend connection //Remove one another from each other's friend list
    public void removeFriend(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }
        removeFriendFromList(user1, userID2);
        removeFriendFromList(user2, userID1);
    }
    // Helper function to remove a friend from a user's friend list
    private void removeFriendFromList(UserNode user, int friendID) {
        if (user.friendList == null) return;
        if (user.friendList.friendID == friendID) {//if 1st friend present in ll we have to remove
            user.friendList = user.friendList.next;
            return;
        }
        FriendNode temp = user.friendList;//friend ll
        while (temp.next != null && temp.next.friendID != friendID) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    // Find mutual friends
    public void findMutualFriends(int userID1, int userID2) {
        UserNode user1 = findUser(userID1);
        UserNode user2 = findUser(userID2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }
        HashSet<Integer> user1Friends = new HashSet<>();
        FriendNode temp1 = user1.friendList;
        while (temp1 != null) {
            user1Friends.add(temp1.friendID);
            temp1 = temp1.next;
        }
        System.out.print("Mutual Friends: ");
        FriendNode temp2 = user2.friendList;
        boolean found = false;
        while (temp2 != null) {
            if (user1Friends.contains(temp2.friendID)) {
                System.out.print(temp2.friendID + " ");
                found = true;
            }
            temp2 = temp2.next;
        }
        if (!found) {
            System.out.print("None");
        }
        System.out.println();
    }
    // Display all friends of a user
    public void displayFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.print("Friends of " + user.name + " (" + user.userID + "): ");
        FriendNode temp = user.friendList;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.friendID + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Search for a user by ID or Name
    public void searchUser(String name, int userID) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userID == userID || temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID=" + temp.userID + ", Name=" + temp.name + ", Age=" + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found!");
    }
    // Count number of friends for a user
    public void countFriends(int userID) {
        UserNode user = findUser(userID);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        int count = 0;
        FriendNode temp = user.friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(user.name + " has " + count + " friends.");
    }
}
// Main class to test functionality
public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMediaNetwork network = new SocialMediaNetwork();
        // Adding users
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 30);
        network.addUser(3, "Charlie", 22);
        network.addUser(4, "David", 28);
        // Adding friends
        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(2, 4);
        // Displaying friends
        network.displayFriends(1);
        network.displayFriends(2);
        network.displayFriends(3);
        // Finding mutual friends
        network.findMutualFriends(1, 2);
        network.findMutualFriends(1, 4);
        // Searching for a user
        network.searchUser("Bob", 0);
        network.searchUser("", 3);
        // Counting friends
        network.countFriends(2);
        // Removing a friend
        network.removeFriend(1, 2);
        System.out.println("After removing friendship between Alice and Bob:");
        network.displayFriends(1);
        network.displayFriends(2);
    }
}
