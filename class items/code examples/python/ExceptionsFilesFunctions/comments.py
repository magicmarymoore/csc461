
# reminders: single line comment

'''
multi
line
'''

"""
also
multiline
"""


def foo(a, b):
    '''
    Yep, comment block INSIDE the function in Python convention!
    Try typing """ + enter outside then inside.""" has extra features

    Python has built in documentation format called doc strings
    Use r"""…""" if you use any backslashes in your docstrings.
    For Unicode docstrings, use u"""…"""
    @param a:
    @type a:
    @param b:
    @type b:
    @return:
    @rtype:
    '''
    x = 0


def goo():
    """
    Doc string style.
    Python support several tag formats.
         File-->settings-->tools-->python integrated tools

    epytext is closest to what you are used to
    BUT reStructureText is the best supported for autodocumentation


    More on this when we hit specialties

    @return:
    @rtype:
    """
    x = 0

