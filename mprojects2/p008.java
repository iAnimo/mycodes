package mprojects2;
//将字符串左侧leftSize的部分和右部分做整体交换
//原地换
public class p008 {
  // 分两部分A,B
  // A逆，B逆
  // (A逆+B逆)逆
  public String rotate1(String s, int leftSize) {
    // 边界
    if (leftSize <= 0 || leftSize >= s.length()) {
      return s;
    }
    return process(s.toCharArray(), 0, leftSize - 1, s.length() - 1);
  }

  private String process(char[] charArray, int left, int mid, int right) {
    reverse(charArray, left, mid);
    reverse(charArray, mid + 1, right);
    reverse(charArray, left, right);
    return String.valueOf(charArray);
  }

  private void reverse(char[] charArray, int left, int right) {
    while (left < right) {
      char temp = charArray[left];
      charArray[left] = charArray[right];
      charArray[right] = temp;
    }
  }

  // 分两部分A,B
  // 若A,B等长，对等替换
  // 若A,B不等长，切分等长，继续对等替换
  public String rotate2(String s, int leftSize) {
    // 边界
    if (leftSize <= 0 || leftSize >= s.length()) {
      return s;
    }
    char[] charArray = s.toCharArray();
    int L = 0;
    int R = charArray.length - 1;
    int lpart = leftSize;
    int rpart = charArray.length - leftSize;

    int size = Math.min(lpart, rpart);
    int diff = lpart - rpart; //左右部分size差值
    reverse2(charArray, L, R, size);
    while ( diff != 0 ) {
      if( diff > 0 ){
        L += size;
        lpart = diff;
      }else{
        R -= size;
        rpart = -diff;
      }
      size = Math.min(lpart, rpart);
      diff = lpart - rpart;
      reverse2(charArray, L, R, size);
    }

    return String.valueOf(charArray);
  }

  private void reverse2(char[] charArray, int leftBound, int rightBound, int size) {//对等替换
    int left = leftBound;
    int right = rightBound - size + 1;
    char temp = 0;
    while ( size-- != 0 ) { 
      temp = charArray[left];
      charArray[left] = charArray[right];
      charArray[right] = temp;
      left ++;
      right ++;
    }
  }
}
