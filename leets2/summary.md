# 01 滑动窗口技巧解决子串问题

1、最小覆盖子串

2、找到字符串中所有字母异位词

3、无重复字符的最长子串

4、模板代码

    int left = 0, right = 0;
    
    while (right < s.size()) {
        window.add(s[right]);
        right++;
        while (valid) {
            window.remove(s[left]);
            left++;
        }
    }

# 02 双指针技巧汇总

双指针技巧还可以分为两类，一类是「快慢指针」，一类是「左右指针」。前者解决主要解决链表中的问题，比如典型的判定链表中是否包含环；后者主要解决数组（或者字符串）中的问题，比如二分查找。

## 快慢指针

1、判定链表中是否含有环

2、已知链表中含有环，返回这个环的起始位置

3、寻找链表的中点

4、寻找链表的倒数第 k 个元素

## 左右指针

1、二分查找

2、两数之和

3、反转数组

4、滑动窗口算法