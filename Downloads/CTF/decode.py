#
# NB : this is not secure
# from http://code.activestate.com/recipes/266586-simple-xor-keyword-encryption/
# added base64 encoding for simple querystring :)
#

import binascii

def xor_crypt_string(data, key='darkc0de.lst', encode=False, decode=False):
    from itertools import izip, cycle
    import base64
    if decode:
        data = base64.decodestring(data)
    xored = ''.join(chr(ord(x) ^ ord(y)) for (x,y) in izip(data, cycle(key)))
    if encode:
        return base64.encodestring(xored).strip()
    return xored


file_open = open('dafuq.txt','wb')
file_open.write(xor_crypt_string('ina.txt', decode=True))
file_open.close()