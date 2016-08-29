import binascii 

def petak_umpat(isi_brankas, kunci_gembok=darkc0de.lst):
    from itertools import izip, cycle
    import base64
    
    xored = ''.join(chr(ord(x) ^ ord(y)) for (x,y) in izip(isi_brankas, cycle(kunci_gembok)))
    xored = base64.encodestring(xored).strip()
    return xored

file_open = open('dafuq.txt','wb')
file_open.write(petak_umpat(content))
file_open.close()
