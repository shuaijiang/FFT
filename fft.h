#include<iostream>
#include<math.h>
#define PI 3.145
using namespace std;

class FFT{
public:
    FFT();
    FFT(int _n);
    void make_window();
    void dofft(double *x, double *y);
    void printRealImaginary(double *x, double *y);
private:
    int n,m;
    double *cos_w;
    double *sin_w;
    double *window;
};
FFT::FFT()
{
    cout<<"FFT"<<endl;
}
FFT::FFT(int _n){
    n = _n;
    cout<<"n="<<n<<endl;
    m = (int)(log(n)/log(2));
    cos_w = new double[n/2];
    sin_w = new double[n/2];
    
    for(int i=0; i<n/2; i++) {
      cos_w[i] = cos(-2*PI*i/n);
      sin_w[i] = sin(-2*PI*i/n);
    }
    //make_window();        
}
void FFT::make_window()
{
    window = new double[n];
    for(int i = 0; i < n; i++)
      window[i] = 0.42 - 0.5 * cos(2*PI*i/(n-1)) 
        + 0.08 * cos(4*PI*i/(n-1));
}
void FFT::printRealImaginary(double *x, double *y)
{
    cout<<"Real:"<<endl;
    for(int i=0;i<n;i++)
        cout<<x[i]<<" ";
    cout<<endl<<"Imaginary:"<<endl;
    for(int i=0;i<n;i++)
        cout<<y[i]<<" ";
    cout<<endl;
}
/*
* fft: in-place radix-2 DIT DFT of a complex input
* x: double array of length n with real part of data 
* y: double array of length n with imag part of data 
* n: length of FFT(must be a power of two)
*/
void FFT::dofft(double * x, double * y)
{
    int i,j,k,n1,n2,a;
    double c,s,e,t1,t2;
  
    // Bit-reverse
    j = 0;
    n2 = n/2;
    for (i=1; i < n - 1; i++) {
        n1 = n2;
        while ( j >= n1 ) {
          j = j - n1;
          n1 = n1/2;
        }
        j = j + n1;
    
        if (i < j) {
          t1 = x[i];
          x[i] = x[j];
          x[j] = t1;
          t1 = y[i];
          y[i] = y[j];
          y[j] = t1;
        }
    }

    // FFT
    n1 = 0;
    n2 = 1;
  
    for (i=0; i < m; i++) {
        n1 = n2;
        n2 = n2 + n2;
        a = 0;
    
        for (j=0; j < n1; j++) {
          c = cos_w[a];
          s = sin_w[a];
          a +=  1 << (m-i-1);

          for (k=j; k < n; k=k+n2) {
            t1 = c*x[k+n1] - s*y[k+n1];
            t2 = s*x[k+n1] + c*y[k+n1];
            x[k+n1] = x[k] - t1;
            y[k+n1] = y[k] - t2;
            x[k] = x[k] + t1;
            y[k] = y[k] + t2;
          }
      }
    }
}
