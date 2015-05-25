#include<iostream>
#include<stdlib.h>
#include<string>
#include"FFT.h"
using namespace std;

void show(Complex x[], int len, string title) {
    cout<<title<<endl;
    cout<<"-------------------"<<endl;
    for (int i = 0; i < len; i++) {
        cout<<x[i].getReal()<<" "<<x[i].getImag()<<endl;
    }
}
int main()
{
    int N = 8;
    Complex *x = new Complex[N];
    for (int i = 0; i < N; i++) {
        x[i] = Complex(i, 0);
        //x[i] = Complex(-2*((double) rand() / (RAND_MAX)) + 1, 0);
    }
    show(x, N, "x");
    
    FFT myfft;
    // FFT of original data
    Complex* y = myfft.fft(x,N);
    show(y, N, "y = fft(x)");

    system("pause");
    return 0;
}
