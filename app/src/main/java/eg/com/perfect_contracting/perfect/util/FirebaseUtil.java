package eg.com.perfect_contracting.perfect.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by MarwaTalaat on 5/3/2017.
 */

public class FirebaseUtil {


    public static DatabaseReference getLandsAdsRef() {
        return FirebaseDatabase.getInstance()
                .getReference("ads")
                .child("lands").getRef();
    }

    public static DatabaseReference getResidentalAdsRef() {
        return FirebaseDatabase.getInstance()
                .getReference("ads")
                .child("residental").getRef();
    }

    public static DatabaseReference getFurnitureAdsRef() {
        return FirebaseDatabase.getInstance()
                .getReference("ads")
                .child("furniture").getRef();
    }

    public static DatabaseReference getApplicansAdsRef() {
        return FirebaseDatabase.getInstance()
                .getReference("ads")
                .child("applicans").getRef();
    }


//
//
//
//    public static DatabaseReference getLikes(String postId) {
//        return FirebaseDatabase.getInstance()
//                .getReference("likes").child(getCurrentUser().getUid())
//                .child(postId);
//    }
//
//
//    public static DatabaseReference getShares(String postId) {
//        return FirebaseDatabase.getInstance()
//                .getReference("shares").child(getCurrentUser().getUid())
//                .child(postId);
//    }
//
//    public static DatabaseReference getLikeRef(String uid) {
//        return FirebaseDatabase.getInstance()
//                .getReference("likes").child(uid);
//    }
//
//
//
//
//    public static DatabaseReference getSharedRef(String uid) {
//        return FirebaseDatabase.getInstance()
//                .getReference("shares").child(uid);
//    }
//
//
//    public static void signOut() {
//        FirebaseAuth.getInstance().signOut();
//    }
}
