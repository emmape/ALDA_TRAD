package alda.tree;

/**
 * Denna klass representerar noderna i ett bin�rt s�ktr�d utan dubletter.
 * 
 * Detta �r den enda av de tre klasserna ni ska g�ra n�gra �ndringar i. (Om ni
 * inte vill l�gga till fler testfall.) De �ndringar som �r till�tna �r dock
 * begr�nsade av f�ljande regler:
 * <ul>
 * <li>Ni f�r INTE l�gga till n�gra fler instansvariabler.
 * <li>Ni f�r INTE l�gga till n�gra statiska variabler.
 * <li>Ni f�r INTE anv�nda n�gra loopar n�gonstans.
 * <li>Ni F�R l�gga till fler metoder, dessa ska d� vara privata.
 * </ul>
 * 
 * @author henrikbe
 * @author Elise Edette (tero0337) tero0337@student.su.se
 * @author Emma Persson (empe5691)
 * @author Aframyeos Rohoum (afro0793)
 * 
 * @param <T>
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {
	BinarySearchTreeNode root;

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	/**
	 * L�gger till en nod i det bin�ra s�ktr�det. Om noden redan existerar s�
	 * l�mnas tr�det of�r�ndrat.
	 * 
	 * @param data
	 *            datat f�r noden som ska l�ggas till.
	 * @return true om en ny nod lades till tr�det.
	 */
	public boolean add(T data) {
		if(this.data == data){
			return false;
		}else if(this.data.compareTo(data) > 0){
			if(left == null){
				left = new BinarySearchTreeNode<T>(data);
				return true;
			}else{
				return left.add(data);
			}
		}else{
			if(right == null){
				right = new BinarySearchTreeNode<T>(data);
				return true;
			}else{
				return right.add(data);
			}
		}
	}

	/**
	 * Privat hj�lpmetod som �r till nytta vid borttag. Ni beh�ver inte
	 * skriva/utnyttja denna metod om ni inte vill.
	 * 
	 * @return det minsta elementet i det (sub)tråd som noden utgör root i.
	 */
	private T findMin() {
		if(left!=null){
			return left.findMin();
		}else{
			return this.data;
		}
	
	}

	/**
	 * Tar bort ett element ur tr�det. Om elementet inte existerar s l�mnas
	 * tr�det of�r�ndrat.
	 * 
	 * @param data
	 *            elementet som ska tas bort ur tr�det.
	 * @return en referens till nodens subtr�d efter borttaget.
	 */
	public BinarySearchTreeNode<T> remove(T data) {
		
		return remove(data, this);
	}
	
	//Att ta bort en Node
	private BinarySearchTreeNode<T> remove(T data, BinarySearchTreeNode<T> typ) {
		if (typ == null || data == null)
			return null;
		int compareResult = data.compareTo(typ.data);

		if (compareResult < 0)
			typ.left = remove(data, typ.left);
		else if (compareResult > 0)
			typ.right = remove(data, typ.right);
		else if (typ.left != null && typ.right != null) {
			typ.data = typ.right.findMin();
			typ.right = remove(typ.data, typ.right);
		} 
		else {
			
			typ = ( typ.left != null ) ? typ.left : typ.right;
		}
		return typ;
	}

	/**
	 * Kontrollerar om ett givet element finns i det (sub)tr�d som noden utg�r
	 * root i.
	 * 
	 * @param data
	 *            det s�kta elementet.
	 * @return true om det s�kta elementet finns i det (sub)tr�d som noden utg�r
	 *         root i.
	 */
	public boolean contains(T data) {
		if(this.data == data){
			return true;
		}else{
			if(this.data.compareTo(data) > 0){
				if(left == null){
					return false;
				}else{
					return left.contains(data);
				}
			}else{
				if(right == null){
					return false;
				}else{
					return right.contains(data);
				}
			}
		}
	}

	/**
	 * Storleken p� det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return det totala antalet noder i det (sub)tr�d som noden utg�r root i.
	 */
	public int size() {
		return 1 + (left == null ? 0 : left.size()) + (right == null ? 0 : right.size());
	}

	/**
	 * Det h�gsta djupet i det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return djupet.
	 */
	public int depth() {
		if(left == null && right == null){
			return 0;
		}else{
			if((left == null ? 0 : left.depth()) < (right == null ? 0 : right.depth())){
				return 1 + right.depth();
			}else{
				return 1 + left.depth();
			}
		}
	}

	/**
	 * Returnerar en str�ngrepresentation f�r det (sub)tr�d som noden utg�r root
	 * i. Denna representation best�r av elementens dataobjekt i sorterad
	 * ordning med ", " mellan elementen.
	 * 
	 * @return str�ngrepresentationen f�r det (sub)tr�d som noden utg�r root i.
	 */
	public String toString() {
		String retval, sright;
		retval = (left == null ? "" : left.toString());
		retval += (retval != "" && data != "" ? ", " + data : "" + data);
		sright = (right == null ? "" :  right.toString());
		retval += (retval != "" && sright != "" ? ", " + sright : "" + sright);
		
		return retval;
	}
}
