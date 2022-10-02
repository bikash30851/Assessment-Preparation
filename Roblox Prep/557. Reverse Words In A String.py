'''
557. Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still 
preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"
'''

class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        #["hehe", "hehe", "hehe", "hehe"] 4-1 = 3

        #split the word delimited by spaces
        list1 = s.split(" ")
        output = ""
        for word in list1:
            revword = ""
            #reverse each word in the list
            for i in word[-1::-1]:
                revword += i
                #add a space at the end of each word.
            if(list1.index(word) != len(list1)-1):
                revword += " "       
            output+=revword
            #strip the trailing space at the end. 
        return output.strip()
    
