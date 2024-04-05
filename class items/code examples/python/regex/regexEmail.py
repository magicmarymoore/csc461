import re

text = [ "aa@bb.cc",  # T
         "aa.bb.dd@bb.cc",  # T
         "aa.bb.bb",  # F
         "aa.bb@bb",  # F
         "aa.bb@bb.cc@bb",  # F
         "aa.bb@bb.cc.bb",  # T
         "aa.bb@bb.cc.",  # F
         "aa.bb@"]  # F

# answer
pat = r"^\w+(\.\w+)*@\w+(\.\w+)+$"

# For speed, can compile and reuse a pattern
pat = re.compile( pat )
ans = map( pat.search, text )  # run test on each item

for i in ans:
    print( i )

# QUESTION: what is the pattern to correct match the above emails


# answer
# r"[.\w]+@([.\w]+\.)+\w+$"
