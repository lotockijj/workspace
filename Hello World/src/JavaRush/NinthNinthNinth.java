package JavaRush;
/* Ñòğîêà - îïèñàíèå
Ââåñòè ñ êëàâèàòóğû öåëîå ÷èñëî â äèàïàçîíå 1 - 999. Âûâåñòè åãî ñòğîêó-îïèñàíèå ñëåäóşùåãî âèäà:
«÷åòíîå îäíîçíà÷íîå ÷èñëî» - åñëè ÷èñëî ÷åòíîå è èìååò îäíó öèôğó,
«íå÷åòíîå îäíîçíà÷íîå ÷èñëî» - åñëè ÷èñëî íå÷åòíîå è èìååò îäíó öèôğó,
«÷åòíîå äâóçíà÷íîå ÷èñëî» - åñëè ÷èñëî ÷åòíîå è èìååò äâå öèôğû,
«íå÷åòíîå äâóçíà÷íîå ÷èñëî» - åñëè ÷èñëî íå÷åòíîå è èìååò äâå öèôğû,
«÷åòíîå òğåõçíà÷íîå ÷èñëî» - åñëè ÷èñëî ÷åòíîå è èìååò òğè öèôğû,
«íå÷åòíîå òğåõçíà÷íîå ÷èñëî» - åñëè ÷èñëî íå÷åòíîå è èìååò òğè öèôğû.
Åñëè ââåäåííîå ÷èñëî íå ïîïàäàåò â äèàïàçîí 1 - 999, â òàêîì ñëó÷àå íè÷åãî íå âûâîäèòü íà ıêğàí.
Ïğèìåğ äëÿ ÷èñëà 100:
÷åòíîå òğåõçíà÷íîå ÷èñëî
Ïğèìåğ äëÿ ÷èñëà 51:
íå÷åòíîå äâóçíà÷íîå ÷èñëî
*/

import java.io.*;

public class NinthNinthNinth{
    public static void main(String[] args) throws Exception{
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String snum = reader.readLine();
        int num = Integer.parseInt(snum);
        if (num>=1&&num<999){
        	if (num%2==0&&snum.length()==1)System.out.println("÷åòíîå îäíîçíà÷íîå ÷èñëî");
            if (num%2==0&&snum.length()==2)System.out.println("÷åòíîå äâóçíà÷íîå ÷èñëî");
            if (num%2==0&&snum.length()==3)System.out.println("÷åòíîå òğåõçíà÷íîå ÷èñëî");
            if (!(num%2==0)&&snum.length()==1)System.out.println("íå÷åòíîå îäíîçíà÷íîå ÷èñëî");
            if (!(num%2==0)&&snum.length()==2)System.out.println("íå÷åòíîå äâóçíà÷íîå ÷èñëî");
            if (!(num%2==0)&&snum.length()==3)System.out.println("íå÷åòíîå òğåõçíà÷íîå ÷èñëî");
          //íàïèøèòå òóò âàø êîä
        }
    } 

}


