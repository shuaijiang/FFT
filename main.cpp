#include<iostream>
#include<stdlib.h>
#include"fft.h"
using namespace std;

int main()
{
    int n = 8;
    double *x = new double[n];
    double *y = new double[n];
    
    FFT fft = FFT(n);
    
    for(int i=0; i<n; i++) {
        x[i] = cos(2*PI*i / n);
        y[i] = 0;
    }
    fft.printRealImaginary(x,y);
    fft.dofft(x,y);
    fft.printRealImaginary(x,y);
    
    for(int i=0; i<n; i++) {
        x[i] = i;
        y[i] = 0;
    }
    fft.printRealImaginary(x,y);
    for(int i=0;i<1;i++)
        fft.dofft(x,y);
    fft.printRealImaginary(x,y);
    system("pause");
    return 0; 
}
