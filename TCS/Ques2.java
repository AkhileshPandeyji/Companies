import java.util.Scanner;

public class Ques2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        count = 0;
        for(int day=n1;day<=n2;day++){            
            for(int h=0;h<=23;h++){
                for(int min=0;min<=59;min++){
                    for(int sec=0;sec<=59;sec++){                        
                        countPalindromes(day, h, min, sec);
                    }
                }
            }
        }
        System.out.println(count);
        scn.close();
    }
    static int count;

    public static void countPalindromes(int cday,int chour,int cmin,int csec){
        
        String day = ""+cday;
        String hour = (chour < 10)?"0"+chour:""+chour;
        String min = (cmin < 10)?"0"+cmin:""+cmin;
        String sec = (csec < 10)?"0"+csec:""+csec;
        String form = day+hour+min+sec;

        boolean flag = false;
        for(int i=0,j=form.length()-1;i<form.length()/2;i++,j--){
            if(form.charAt(i) == form.charAt(j)){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }

        if(flag){
            count++;
        }   
        // System.out.println(form+" "+count);     
    }
}