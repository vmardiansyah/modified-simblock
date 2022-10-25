/**
 * Copyright 2019 Distributed Systems Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package SimBlock.block;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import SimBlock.node.Node;
import static SimBlock.settings.SimulationConfiguration.*;
import static SimBlock.simulator.Main.*;
import static SimBlock.simulator.Simulator.*;

public class SampleProofOfStakeBlock extends Block {
	private Map<Node, Coinage> coinages;
	private static Map<Node, Coinage> genesisCoinages;
	private BigInteger difficulty;
	private BigInteger totalDifficulty;
	private BigInteger nextDifficulty;

//	public SampleProofOfStakeBlock(SampleProofOfStakeBlock parent, Node minter, long time, BigInteger difficulty) {
//		super(parent, minter, time);
	public SampleProofOfStakeBlock(SampleProofOfStakeBlock parent, Node minter, long time, int Noncenya, BigInteger difficulty) {
		super(parent, minter, time, Noncenya);

		this.coinages = new HashMap<Node, Coinage>();
		if (parent == null) {
			for (Node node : getSimulatedNodes()) {
				this.coinages.put(node, genesisCoinages.get(node).clone());
			}
		} else {
			for (Node node : getSimulatedNodes()) {
				this.coinages.put(node, parent.getCoinage(node).clone());
				this.coinages.get(node).increaseAge();
			}
			this.coinages.get(minter).reward(STAKING_REWARD);
			this.coinages.get(minter).resetAge();
		}

		BigInteger totalCoinage = BigInteger.ZERO;
		for (Node node : getSimulatedNodes()) {
			totalCoinage = totalCoinage.add(this.coinages.get(node).getCoinage());
		}

		this.difficulty = difficulty;
		this.totalDifficulty = (parent == null ? BigInteger.ZERO : parent.getTotalDifficulty()).add(difficulty);
		this.nextDifficulty = totalCoinage.multiply(BigInteger.valueOf(getTargetInterval())).divide(BigInteger.valueOf(1000));
	}

	public Coinage getCoinage(Node node) {return this.coinages.get(node);}
	public BigInteger getDifficulty() {return this.difficulty;}
	public BigInteger getTotalDifficulty() {return this.totalDifficulty;}
	public BigInteger getNextDifficulty() {return this.nextDifficulty;}

	private static Coinage genCoinage() {
		double r = random.nextGaussian();
		return new Coinage(BigInteger.valueOf(Math.max((int)(r * STDEV_OF_COINS + AVERAGE_COINS),0)),1);
	}

	public static SampleProofOfStakeBlock genesisBlock(Node minter) {
		genesisCoinages = new HashMap<Node, Coinage>();
		for(Node node : getSimulatedNodes()){
			genesisCoinages.put(node, genCoinage());
		}
//		return new SampleProofOfStakeBlock(null, minter, 0, BigInteger.ZERO);
		return new SampleProofOfStakeBlock(null, minter, 0, 0, BigInteger.ZERO);  // Modification By Viddi
	}
}
