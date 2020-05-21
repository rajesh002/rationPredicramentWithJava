
public class Main {

	public static void main(String[] args) {
		int quantity=123;
		double sizes[]={0.5, 1, 2, 5};
		int logistic_constraints[]={50,50,50,30};
		int topups[]={10,10,10,10};
		int available_capacity[]={63, 125, 40, 20};
		allocate(quantity,sizes,logistic_constraints,topups,available_capacity);
	}
	
	
	
	private static void allocate(int quantity, double[] sizes, int[] logistic_constraints, int[] topups,
			int[] available_capacity) {
		int allocated = 0;
		int remainder=0;
		int allocations[]=new int[sizes.length];
		int post_allocation[]=new int[sizes.length];
		for(int index=0;index<logistic_constraints.length;index++) {
			if(available_capacity[index]<logistic_constraints[index]) {
				allocations[index]=0;
			}
			else {
				int temp=(available_capacity[index]%topups[index]);
				for(int initial=logistic_constraints[index];initial<=available_capacity[index]-temp && initial<logistic_constraints[index]*2;initial+=10) {
					allocated=initial;
				}
				allocations[index]=allocated;
			}
			post_allocation[index]=available_capacity[index]-allocations[index];
			System.out.println(allocations[index]);	
			System.out.println(post_allocation[index]);	
			remainder+=allocations[index]*sizes[index];
		}
		quantity-=remainder;
		System.out.println(quantity);
	}	
}
