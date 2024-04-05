# packages are based on folder structure like java. BUT, no need to explcitly name them
import array #Java --> include  import array.*
from random import gauss #Java --> include  import random.gauss
# import random
from math import sqrt
from math import fabs

x = sqrt( 2 )

# need array.____ since I imported EVERYTHING from the array.py file
y = array.array( 'l', [ 1, 2, 3, 4 ] )

# fails since the type does not match...normal python arrays do not restrict to one type
# y2 = array.array('l', [1,2.2,3,4])

mu = 2
sigma = 3
z = gauss( mu, sigma )  # partial import
#z = random.gauss(mu, sigma)    #full import gauss
