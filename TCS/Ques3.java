import java.util.Scanner;

public class Ques3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int h = scn.nextInt();
        int[] larr = new int[n];
        for(int i=0;i<n;i++){
            larr[i] = scn.nextInt();
        }
        int voldiff = volumeDiff(larr,b,h);
        System.out.println(voldiff);
        scn.close();
    }
    public static int volumeDiff(int[] larr,int b,int h){
        int left=0,right=0;
        int volume = 0;
        int maxVol = 0;
        int sum = 0;
        for(int i=0;i<larr.length;i++){
            left = 0;
            right = 0;
            for(int l=i-1;l>=0;l--){
                if(larr[l] - larr[i] >= 0){
                    left++;
                }
                else{
                    break;
                }
            }
            for(int r=i+1;r<larr.length;r++){
                if(larr[r] - larr[i] >=0){
                    right++;
                }
                else{
                    break;
                }
            }
            volume = (((left+right+1)*b)*h)*larr[i];
            sum += larr[i];
            if(volume>maxVol){
                maxVol = volume;
            }
        }
        int voldiff = (((sum*b)*h) - maxVol);
        return voldiff;
    }
}