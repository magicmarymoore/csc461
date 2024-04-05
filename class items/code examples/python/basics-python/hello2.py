# # is a single line comment

"""
Multi line comment
"""
'''
Also a multi line comment...but allows extras. More on this later
'''

# fakes main
if __name__ == '__main__':
    x = 2;   # <-- ; is legal, and separates statements, but BAD practice
    #   y = 2 #is illegal since not consistently indented

    # the slash permits multiline statements
    print( "Hello" + \
           " There" )
