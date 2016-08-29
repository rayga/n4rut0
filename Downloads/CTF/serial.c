#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int num = 0x1337;

void lindungi()
{
    gid_t gid = getgid();
    setresgid(gid, gid, gid);
}

int main(int argc, char **argv)
{
//    int num2 = 0xd4d1;
    int *ptr = &num1;
    printf(argv[1]);

    if(num1 == 0xc0de){
        system("cat flag");
    }
    printf("\n[DEBUG] num: 0x%x [%p]\n", num, &num);
    return 0;
}

