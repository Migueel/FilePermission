import java.io.FilePermission;
import java.io.IOException;
import java.security.PermissionCollection;

public class FilePermissionDemo {
   
   static FilePermission fp = null;
   static PermissionCollection pc = null;
   
   public static void main(String[] args) throws IOException {
      try{
         // create new file permissions
         fp = new FilePermission("C://test.txt", "read");

         // create new permission collection
         pc = fp.newPermissionCollection();
         
         // add permission to the permission collection
         pc.add(fp);
          
         // tests if the file permission is read
         TestFileReadPermission("C://test.txt");
         
      }catch(Exception ex){
         // if an error occurs
         ex.printStackTrace();
      }
   } 
   // method to test file permission
   public static void TestFileReadPermission(String path)
   {
      if(pc.implies(new FilePermission("C://test.txt", "read"))) {
         System.out.println("Permission for "+path+" is read");
      }
   }
}
