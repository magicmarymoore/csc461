# CSC461 Programming Languages, Fall 2018 (LRR)
# suggested practice site: https://regex101.com/
import re, string

'''
regex (regular expressions), is a pattern matching languages for text. 

If there are no special characters it matches exactly.



Most common special characters
.      Matches any character except a newline                                   h.t --> hat, hot, hit
^      Matches the start of the string                                          ^h.t  ("hat hot hit") -->hat
$      Matches the end of the string
*      Causes the resulting RE to match 0 or more repetitions of the preceding RE  a* --> a, aa, aaaa, aaa, null
+      Causes the resulting RE to match 1 or more repetitions of the preceding RE
?      Causes the resulting RE to match 0 or 1 repetitions of the preceding RE      dogs? ---> dog, dogs
{m}    Specifies that exactly m copies of the previous RE should be matched         a{2} --> aa
{m,n}  Specifies that m to n copies of the previous RE should be matched            a{2, 4} --> aa, aaa, aaaa
           (append ? To get fewest repetition)                                      style=".*?" --> style="a" BUT NOT --> style="a"a"
\      Either escapes special characters (e.g. '*', '?'),                           \* --> *
            OR signals a special character class(e.g. \dany digit)
|      Match EITHER pattern                                                         hat|hit  --> hat, hit
(...)  Matches the pattern inside the parentheses, and makes it a “group”           (h|g)it --> hit, git
        The contents of a group can be retrieved later with the "\number" in sequence
[]      Used to indicate a set of characters (MULTIPLE WARNINGS!).    
            Special characters lose their meaning (e.g. [+*] matches any of these characters: +*
            Character classes such as \d are accepted inside a set as normal 
            Use ^ to negate the set (e.g. [^5] will match any character except '5’)
            - between two RE means range         
\s      is any whitespace character (\S negates the meaning)
\w      is any word character, i.e. [a-zA-Z0-9_ (\W negates the meaning)
\b word boundary (\B negates the meaning)
\d      is a digit

A raw string, one we do not have to add \s to all special characters:
r’...’

'''

line = r'\this, is - a line; broken. by! miscellaneous: punctuation! A** ^'

print('Original string of text:')
print(line)

print('\nSplit after substituting white space for some punctuation:')
subs = re.sub(r'[.,;!\\]', ' ', line)  # target, swap with something else
print(subs)
print(subs.split())

print('\nSplit after substituting white space for all punctuation:')
# use predefined string patterns
pattern = '[' + string.whitespace + string.punctuation + string.digits + ']'
subs = re.sub(pattern, ' ', line)
print(subs)
print(subs.split())

print('\nFind first word')
word = re.search('\w+', line.lower())  # find first word
print("returned object:", word, "-->Matched item:", word[0])  # print match

print('\nFind groups')
word = re.search('(\w+) (\w+)', line.lower())  # find first 2 word with a single space between them
print("returned object:", word, "-->Matched item:", word.groups())  # print match

print('\nFinding all words')
words = re.findall('\w+', line.lower())  # convert to lower case and split into words
if len(words) > 0:
    print(words)  # print word list



#Question: use regex to find all words that start with b






#Answer:
print('\nFinding all words starting with b')
words = re.findall('b\w+', line.lower())  # convert to lower case and split into words
if len(words) > 0:
    print(words)  # print word list
