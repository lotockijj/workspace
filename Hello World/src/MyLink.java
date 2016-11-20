
class MyLink {  
    public MyLink() { 
        str = "New"; 
    } 
    public String str; 
  
    public static void main(String[] args) { 
        MyLink b1 = new MyLink(); 
        MyLink b2 = b1; 
        b2.str = "My String"; 
        System.out.println(b1.str); 
 
        String a1 = "Test"; 
        String a2 = a1; 
        System.out.println(a2); 
        a1 = "Not a Test"; 
        System.out.println(a2); 
    } 
}