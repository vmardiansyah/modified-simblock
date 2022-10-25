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

import SimBlock.node.Node;
import SimBlock.node.StringUtil;

import static SimBlock.settings.SimulationConfiguration.*;

import java.text.SimpleDateFormat;   // Add By Viddi

public class Block {
	private int height;
	private Block parent;
	private Node minter;
	private long time;
	private int id;
	private int idHeight = 0;
	// Added and Modified By Viddi
	private int Noncenya;      													// Add By Viddi
	private String Hashnya;															// Add By Viddi
	private String PrevHashnya;													// Add By Viddi
	private String TimeStamp;														// Add By Viddi
	// End of Addition and Modified By Viddi
	private static int latestId = 0;

// Added and Modified By Viddi
//  Penambahan int Noncenya   By Viddi
//	public Block(Block parent, Node minter, long time){
	public Block(Block parent, Node minter, long time, int Noncenya){
// End of Addition and Modified By Viddi
		this.height = parent == null ? 0 : parent.getHeight() + 1;
		this.parent = parent;
		this.minter = minter;
		this.time = time;
		this.id = latestId;

		// Added and Modified By Viddi
		this.TimeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		this.Noncenya = Noncenya;
		if (latestId == 0){
			this.Hashnya = this.HitungHash();
			this.PrevHashnya = "0";
			idHeight = 0;
			System.out.println("Genesis "+idHeight);
		}
		else{
			this.Hashnya = this.HitungHash();
			this.CariMine(DIFFICULTY);
			this.PrevHashnya = parent.getHashnya();
			idHeight = latestId;
			System.out.println("chain "+idHeight);
		}
		// End of Addition and Modified By Viddi

		latestId++;
	}

	public int getHeight(){return this.height;}
	public Block getParent(){return this.parent;}
	public Node getMinter(){return this.minter;}
	public long getTime(){return this.time;}
	public int getId() {return this.id;}

	// Added and Modified By Viddi
	public int getidHeight() {return this.idHeight;}
	public int getNoncenya() {return this.Noncenya;}			// Add By Viddi
	public String getHashnya() {return this.Hashnya;}			// Add By Viddi
	public String getPrevHashnya() {return this.PrevHashnya;}			// Add By Viddi
	public String getTimeStamp() {return this.TimeStamp;}			// Add By Viddi
	// End of Addition and Modified By Viddi

	public static Block genesisBlock(Node minter) {
//		return new Block(null, minter, 0);
		return new Block(null, minter, 0, 0); 							// Modification By Viddi
	}

	// return ancestor block that height is {height}
	public Block getBlockWithHeight(int height) {
		if (this.height == height) {
			return this;
		} else {
			return this.parent.getBlockWithHeight(height);
		}
	}

	public boolean isOnSameChainAs(Block block) {
		if (block == null) {
			return false;
		} else if (this.height <= block.height) {
			return this.equals(block.getBlockWithHeight(this.height));
		} else {
			return this.getBlockWithHeight(block.height).equals(block);
		}
	}

  // Added and Modified By Viddi
	public String HitungHash(){
		if ((idHeight>0) && (this.id == idHeight)) {
//			System.out.println(idHeight);
			return this.Hashnya;
		} else {
				String hitunghash =  StringUtil.applySha256(Integer.toString(this.id) + this.Noncenya + this.TimeStamp);
//				System.out.println("==>" + idHeight);
				return hitunghash;
		}
	}

	public void CariMine(int difficulty){
		while(!this.Hashnya.substring(0, difficulty).equals(StringUtil.repeat(difficulty,"0"))){
			this.Noncenya++;
			this.Hashnya = this.HitungHash();
		}
	}
	// End of Addition and Modified By Viddi
}
