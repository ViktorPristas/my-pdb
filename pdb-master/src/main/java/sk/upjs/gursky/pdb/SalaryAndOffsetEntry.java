package sk.upjs.gursky.pdb;

import java.nio.ByteBuffer;

import sk.upjs.gursky.bplustree.BPObject;

public class SalaryAndOffsetEntry implements BPObject<PersonSalaryKey, SalaryAndOffsetEntry> {

	private static final long serialVersionUID = 6636012031385997564L;
	int salary; 
	long offset; // 8B
	
	public SalaryAndOffsetEntry() {
		
	}	

	public SalaryAndOffsetEntry(int salary, long offset) {
		super();
		this.salary = salary;
		this.offset = offset;
	}


	@Override
	public int compareTo(SalaryAndOffsetEntry o) {
		// TODO Auto-generated method stub
		if (this.salary < o.salary) 
			return -1;
		if (this.salary > o.salary)
			return 1;		
		return 0;
	}

	@Override
	public void load(ByteBuffer bb) {		
		salary = bb.getInt();
		offset = bb.getLong();
	}

	@Override
	public void save(ByteBuffer bb) {
		bb.putInt(salary);
		bb.putLong(offset);

	}

	@Override
	public int getSize() {
		return 28;
	}

	@Override
	public PersonSalaryKey getKey() {
		return new PersonSalaryKey(salary);
	}
	
	public int getSalary() {
		return salary;
	}
	
	public long getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return "SalaryAndOffsetEntry [salary=" + salary + ", offset=" + offset + "]";
	}

}
