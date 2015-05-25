#include<iostream>
#include<stdlib.h>
#include"complex.h"

using namespace std;

int main()
{
    Complex a = Complex(5,6);
    Complex b = Complex(-3,4);
    Complex res = a.plus(b);
    cout<<res.getReal()<<" "<<res.getImag()<<endl;
    
    res = a.divides(b);
    cout<<res.getReal()<<" "<<res.getImag()<<endl;
    
    double n = a.compAbs();
    cout<<"a.abs()="<<n<<endl;
    
    res = a.compTan();
    cout<<res.getReal()<<" "<<res.getImag()<<endl;
    system("pause");
    return 0;
}
