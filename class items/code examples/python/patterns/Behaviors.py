#to add sound for versions <3.9
# go to file-->settings-->project: <NAME>-->Project Interpreter-->
# the plus sign-->search for playsound-->install
#
# For version 3.9, search for python-vlc

SOUND_INSTALLED = True

def mySound( file ):
    pass

if(SOUND_INSTALLED):
    import sys
    start = sys.version.find('.')
    end = sys.version.find('.', start+1)
    version = sys.version[start+1: end]
    version = float(version)

    #version 3.9+ is broken with playsounds for most files
    #use vlc instead
    if(version>=9):
        try:
            import vlc
            import time
            def f(file):
                p = vlc.MediaPlayer( file )
                p.play( )
                time.sleep( 0.5 )
                duration = p.get_length( ) / 1000
                time.sleep( duration )
            mySound = f
        except Exception:
            print ("No sound library installed")

    else:
        try:
            from playsound import playsound
            import time
            def f( file ):
                playsound(file)
            mySound = f
        except Exception:
            print ("No sound library installed")


def bird(  ):
    #print( self.name ) #this should not compile
    print("chirp")

    if (SOUND_INSTALLED):
        mySound( 'chickdca.wav' )

def dog(  ):
    print( "bark" )

    if (SOUND_INSTALLED):
        mySound( 'bark5.wav' )


def cat(  ):
    print( "meow" )

    if (SOUND_INSTALLED):
        mySound( 'cat.wav' )







#deep binding examples--------------------------------------------------
def birdName( self ):
    print( self._name, end = "-->" )
    print("chirp")

    if (SOUND_INSTALLED):
        mySound( 'chickdca.wav' )

def dogName( self ):
    print( self._name, end = "-->"  )
    print( "bark" )

    if(SOUND_INSTALLED):
        mySound( 'bark5.wav' )

def catName( self ):
    print( self._name, end = "-->"  )
    print( "meow" )

    if(SOUND_INSTALLED):
        mySound( 'cat.wav' )