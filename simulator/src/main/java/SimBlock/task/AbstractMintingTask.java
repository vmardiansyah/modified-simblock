package SimBlock.task;

import SimBlock.block.Block;
import SimBlock.node.Node;

public abstract class AbstractMintingTask implements Task {
	private Node minter;
	private Block parent;
	private long interval;
	private int Noncenya;

	public AbstractMintingTask(Node minter, long interval, int Noncenya) {
		this.parent = minter.getBlock();
		this.minter = minter;
		this.interval = interval;
		this.Noncenya = Noncenya;
	}

	public Node getMinter() {
		return minter;
	}

	public Block getParent() {
		return parent;
	}

	public int getNoncenya() {
		return Noncenya;
	}

	@Override
	public long getInterval() {
		return this.interval;
	}
}
