package collection;

import java.util.*;

class Company{
   private int cmpid;        
   private String cname;
   private int rating;

   Company(int cmpid, String cname, int rating){   
      this.cmpid = cmpid;
      this.cname = cname;
      this.rating = rating;
   }

   public int getCmpid(){
      return cmpid;
   }
   public int getRating(){
      return rating;
   }
   public String getCname(){
      return cname;
   }

   public String toString(){
      return cmpid+" "+cname+" "+rating;
   }
}

class CRUD{
   public static void main(String[] args) {
      
      List<Company> c = new ArrayList<Company>();   
      Scanner s = new Scanner(System.in);
      Scanner s1 = new Scanner(System.in);
      int ch;
      do{
         System.out.println("1.INSERT");
         System.out.println("2.DISPLAY");
         System.out.println("3.SEARCH");
         System.out.println("4.DELETE");
         System.out.println("5.UPDATE");
         System.out.print("Enter Your Choice : ");
         ch = s.nextInt();

         switch(ch){
            case 1:
               System.out.print("Enter Comapny id : ");
               int cid = s.nextInt();
               System.out.print("Enter Comapny Name : ");
               String cname = s1.nextLine();
               System.out.print("Enter rating out of 5 : ");
               int rating = s.nextInt();

            
               c.add(new Company(cid,cname,rating)); 

            break;
            case 2:
               System.out.println("----------------------------");
               Iterator<Company> i = c.iterator();
               while(i.hasNext()){
                  Company cm = i.next(); 
                  System.out.println(cm);
               }
               System.out.println("----------------------------");
            break;
            case 3:
               boolean found = false;
               System.out.print("Enter Company id to Search :");
               int cmpid = s.nextInt();
               System.out.println("----------------------------");
               i = c.iterator();
               while(i.hasNext()){
                  Company cm = i.next();
                  if(cm.getCmpid() == cmpid)  {
                     System.out.println(cm);
                     found = true;
                  }
               }
               
               if(!found){
                  System.out.println("Record Not Found");
               }
               System.out.println("----------------------------");
            break;

            case 4:
               found = false;
               System.out.print("Enter Comapny id to Delete :");
               cmpid = s.nextInt();
               System.out.println("----------------------------");
               i = c.iterator();
               while(i.hasNext()){
                  Company cm = i.next();
                  if(cm.getCmpid() == cmpid)  {
                     i.remove();
                     found = true;
                  }
               }
               
               if(!found){
                  System.out.println("Record Not Found");
               }else{
                  System.out.println("Record is Deleted Successfully...!");
               }

               System.out.println("----------------------------");
            break;
            case 5:
               found = false;
               System.out.print("Enter Comapny id to Update :");
               cmpid = s.nextInt();
               
               ListIterator<Company>li = c.listIterator();
               while(li.hasNext()){
                  Company cm = li.next();
                  if(cm.getCmpid() == cmpid)  {
                     System.out.print("Enter new Name : ");
                     cname = s1.nextLine();

                     System.out.print("Enter new rating : ");
                     rating = s.nextInt();
                     li.set(new Company(cmpid,cname,rating));
                     found = true;
                  }
               }
               
               if(!found){
                  System.out.println("Record Not Found");
               }else{
                  System.out.println("Record is Updated Successfully...!");
               }

               
            break;

            
         }
      }while(ch!=0);
   }
}


