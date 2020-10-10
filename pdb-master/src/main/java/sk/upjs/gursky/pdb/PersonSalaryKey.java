package sk.upjs.gursky.pdb;

import java.nio.ByteBuffer;

import sk.upjs.gursky.bplustree.BPKey;

public class PersonSalaryKey implements BPKey<PersonSalaryKey> {

	private static final long serialVersionUID = 2784314044852195831L;
	private int key;
	
	public PersonSalaryKey() {}
	
	public PersonSalaryKey(int key) {
		
		this.key = key;
	}
	
	public int getSize() {
		
		return 4;
	}
	
	public void load(ByteBuffer bb) {
		key = bb.getInt();
	}
	
	public void save(ByteBuffer bb) {
		bb.putInt(key);
	}
	
	public int compareTo(PersonSalaryKey personSalaryKey) {
		if (key < personSalaryKey.key)
			return -1;
		if (key > personSalaryKey.key) 
			return 1;		
		return 0;
	}
}
