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
package SimBlock.settings;

public class SimulationConfiguration {
	public static final int NUM_OF_NODES = 3;//125;//250;//500;//1000

	public static final String TABLE = "SimBlock.node.routingTable.BitcoinCoreTable";
//	public static final String ALGO = "SimBlock.node.consensusAlgo.SampleProofOfStake";
	public static final String ALGO = "SimBlock.node.consensusAlgo.ProofOfWork";

	// Unit: millisecond
	public static final long INTERVAL = 1000*60*10;//1000*60;//1000*30*5;//1000*60*10;

	// Mining power is the number of mining (hash calculation) executed per millisecond.
	public static final int AVERAGE_MINING_POWER = 4;  //400000;
	public static final int STDEV_OF_MINING_POWER = 1; //100000;

	public static final int AVERAGE_COINS = 4000;
	public static final int STDEV_OF_COINS = 2000;

	public static final double STAKING_REWARD = 0.01;

	public static final int ENDBLOCKHEIGHT = 5; //100

	// Unit: byte
	public static final long BLOCKSIZE = 535000;//6110;//8000;//535000;//0.5MB


  // Modification by Viddi
  // 1 = Very Easy
  // 2 = Easy
  // 3 = Moderate
  // 4 = Hard
  // 5 = Very Hard
  public static final int DIFFICULTY = 6;

}
