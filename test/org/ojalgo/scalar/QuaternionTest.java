/*
 * Copyright 1997-2017 Optimatika
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.ojalgo.scalar;

import org.ojalgo.TestUtils;
import org.ojalgo.constant.PrimitiveMath;
import org.ojalgo.function.QuaternionFunction;
import org.ojalgo.matrix.store.MatrixStore;
import org.ojalgo.matrix.store.PhysicalStore;
import org.ojalgo.matrix.store.PrimitiveDenseStore;

public class QuaternionTest extends ScalarTests {

    public QuaternionTest() {
        super();
    }

    public QuaternionTest(final String name) {
        super(name);
    }

    public void _testCosAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpOriginal = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpOp = QuaternionFunction.COS.invoke(tmpOriginal);
                        final Quaternion tmpInv = QuaternionFunction.ACOS.invoke(tmpOriginal);

                        final Quaternion tmpInvOp = QuaternionFunction.ACOS.invoke(tmpOp);
                        final Quaternion tmpOpInv = QuaternionFunction.COS.invoke(tmpInv);

                        TestUtils.assertEquals(tmpOriginal, tmpInvOp);
                        TestUtils.assertEquals(tmpOriginal, tmpOpInv);
                    }
                }
            }
        }
    }

    public void _testCoshAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpOriginal = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpOp = QuaternionFunction.COSH.invoke(tmpOriginal);
                        final Quaternion tmpInv = QuaternionFunction.ACOSH.invoke(tmpOriginal);

                        final Quaternion tmpInvOp = QuaternionFunction.ACOSH.invoke(tmpOp);
                        final Quaternion tmpOpInv = QuaternionFunction.COSH.invoke(tmpInv);

                        TestUtils.assertEquals(tmpOriginal, tmpInvOp);
                        TestUtils.assertEquals(tmpOriginal, tmpOpInv);
                    }
                }
            }
        }
    }

    public void _testSinAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpOriginal = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpOp = QuaternionFunction.SIN.invoke(tmpOriginal);
                        final Quaternion tmpInv = QuaternionFunction.ASIN.invoke(tmpOriginal);

                        final Quaternion tmpInvOp = QuaternionFunction.ASIN.invoke(tmpOp);
                        final Quaternion tmpOpInv = QuaternionFunction.SIN.invoke(tmpInv);

                        TestUtils.assertEquals(tmpOriginal, tmpInvOp);
                        TestUtils.assertEquals(tmpOriginal, tmpOpInv);
                    }
                }
            }
        }
    }

    public void _testSinhAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpOriginal = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpOp = QuaternionFunction.SINH.invoke(tmpOriginal);
                        final Quaternion tmpInv = QuaternionFunction.ASINH.invoke(tmpOriginal);

                        final Quaternion tmpInvOp = QuaternionFunction.ASINH.invoke(tmpOp);
                        final Quaternion tmpOpInv = QuaternionFunction.SINH.invoke(tmpInv);

                        TestUtils.assertEquals(tmpOriginal, tmpInvOp);
                        TestUtils.assertEquals(tmpOriginal, tmpOpInv);
                    }
                }
            }
        }
    }

    public void _testTanAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpOriginal = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpOp = QuaternionFunction.TAN.invoke(tmpOriginal);
                        final Quaternion tmpInv = QuaternionFunction.ATAN.invoke(tmpOriginal);

                        final Quaternion tmpInvOp = QuaternionFunction.ATAN.invoke(tmpOp);
                        final Quaternion tmpOpInv = QuaternionFunction.TAN.invoke(tmpInv);

                        TestUtils.assertEquals(tmpOriginal, tmpInvOp);
                        TestUtils.assertEquals(tmpOriginal, tmpOpInv);
                    }
                }
            }
        }
    }

    public void _testTanhAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpOriginal = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpOp = QuaternionFunction.TANH.invoke(tmpOriginal);
                        final Quaternion tmpInv = QuaternionFunction.ATANH.invoke(tmpOriginal);

                        final Quaternion tmpInvOp = QuaternionFunction.ATANH.invoke(tmpOp);
                        final Quaternion tmpOpInv = QuaternionFunction.TANH.invoke(tmpInv);

                        TestUtils.assertEquals(tmpOriginal, tmpInvOp);
                        TestUtils.assertEquals(tmpOriginal, tmpOpInv);
                    }
                }
            }
        }
    }

    public void testLogExpAndBackAgain() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpQuaternion = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final Quaternion tmpLog = QuaternionFunction.LOG.invoke(tmpQuaternion);
                        final Quaternion tmpExp = QuaternionFunction.EXP.invoke(tmpQuaternion);

                        final Quaternion tmpExpLog = QuaternionFunction.EXP.invoke(tmpLog);
                        final Quaternion tmpLogExp = QuaternionFunction.LOG.invoke(tmpExp);

                        TestUtils.assertEquals(tmpQuaternion, tmpExpLog);
                        TestUtils.assertEquals(tmpQuaternion, tmpLogExp);
                    }
                }
            }
        }
    }

    public void testPolarForm() {

        final double[] tmpArguments = new double[] { PrimitiveMath.NEG, PrimitiveMath.ZERO, PrimitiveMath.ONE };

        for (int s = 0; s < tmpArguments.length; s++) {
            for (int i = 0; i < tmpArguments.length; i++) {
                for (int j = 0; j < tmpArguments.length; j++) {
                    for (int k = 0; k < tmpArguments.length; k++) {

                        final Quaternion tmpExpected = Quaternion.of(tmpArguments[s], tmpArguments[i], tmpArguments[j], tmpArguments[k]);

                        final double tmpNorm = tmpExpected.norm();
                        final double[] tmpUnit = tmpExpected.unit();
                        final double tmpAngle = tmpExpected.angle();

                        final Quaternion tmpActual = Quaternion.makePolar(tmpNorm, tmpUnit, tmpAngle);

                        TestUtils.assertEquals(tmpExpected, tmpActual);
                    }
                }
            }
        }
    }

    public void testRandomMultiplication() {

        final Quaternion normalizedRandomRotation = Quaternion.of(Math.random(), Math.random(), Math.random(), Math.random()).signum();

        TestUtils.assertEquals(normalizedRandomRotation, normalizedRandomRotation.toMultiplicationMatrix());

        final Quaternion randomQuat = Quaternion.of(Math.random(), Math.random(), Math.random());

        final Quaternion quatResult = normalizedRandomRotation.multiply(randomQuat);

        final MatrixStore<Double> vctrResult = normalizedRandomRotation.toMultiplicationMatrix().multiply(randomQuat.toMultiplicationVector());

        TestUtils.assertEquals(vctrResult, quatResult.toMultiplicationVector());
    }

    public void testRandomRotation() {

        final Quaternion normalizedRandomRotation = Quaternion.of(Math.random(), Math.random(), Math.random(), Math.random()).signum();

        final Quaternion randomPureQuat = Quaternion.of(Math.random(), Math.random(), Math.random());

        final Quaternion quatResult = normalizedRandomRotation.multiply(randomPureQuat).multiply(normalizedRandomRotation.conjugate());

        final MatrixStore<Double> vctrResult = normalizedRandomRotation.toRotationMatrix().multiply(randomPureQuat.vector());

        TestUtils.assertEquals(vctrResult, quatResult.vector());

        final PhysicalStore<Double> vector = randomPureQuat.vector();
        vector.transform(normalizedRandomRotation);

        TestUtils.assertEquals(vctrResult, vector);
    }

    public void testRotationMatrixMathWorksExample() {

        final double nmbr = 1.0 / Math.sqrt(2.0);

        final Quaternion rotQuat = Quaternion.of(nmbr, nmbr, 0.0, 0.0);

        final PrimitiveDenseStore expected = PrimitiveDenseStore.FACTORY.columns(new double[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 0, -1, 0 } });

        final MatrixStore<Double> actual = rotQuat.toRotationMatrix();

        TestUtils.assertEquals(expected, actual);

    }

}
