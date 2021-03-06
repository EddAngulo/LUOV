/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package field;

/**
 *
 * @author Ricardo Villanueva
 * @author Eduardo Angulo
 */
public class Field247 extends Field2n {
    
    public Field247() {
        super(47, 0, 0, 5);
    }
    
    @Override
    protected int[] reduction_rep(int[] b_rep) {
        int T;
        for (int i = b_rep.length - 1; i >= 2; i--) {
            T = b_rep[i];
            
            b_rep[i - 1] = b_rep[i - 1] ^ (T >>> 10) ^ (T >>> 15);
            b_rep[i - 2] = b_rep[i - 2] ^ (T << 22) ^ (T << 17);
        }
        T = (b_rep[1] >>> 15);
        b_rep[0] = b_rep[0] ^ T ^ (T << 5);
        int [] b_out = new int[2];
        b_out[1] = b_rep[1] & ((1 << 15) - 1);
        b_out[0] = b_rep[0];
        return b_out;
    }

    @Override
    protected int[] zero_rep() {
        int[] zero = {0x0, 0x0};
        return zero;
    }

    @Override
    protected int[] one_rep() {
        int[] one = {0x1, 0x0};
        return one;
    }

    @Override
    protected int[] xsqrt_rep() {
        int[] x_sqrt = {0x1000008, 0x0};
        return x_sqrt;
    }
    
}
