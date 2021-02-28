package mprojects;

public class m005 {
    public String replaceSpace(String s){
        int n = s.length();
        //charAt
        int size=0;
        char[] arr = new char[n*3];
        for(int i=0; i<n; i++){
            char c=s.charAt(i);
            if( c == ' '){
                arr[size ++]='%';arr[size ++]='2';arr[size ++]='0';
            }else{
                arr[size ++]=c;
            }
        }
        return new String(arr, 0, size);
        // return arr.toString();
    }
}
