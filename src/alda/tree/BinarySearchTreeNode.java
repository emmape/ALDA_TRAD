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
 * 
 * @param <T>
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {

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
		}else if(this.data.compareTo(data) < 0){
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
	 * @return det minsta elementet i det (sub)tr�d som noden utg�r root i.
	 */
	private T findMin() {
		return null;
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
		return null;
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
		return false;
	}

	/**
	 * Storleken p� det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return det totala antalet noder i det (sub)tr�d som noden utg�r root i.
	 */
	public int size() {
		return 0;
	}

	/**
	 * Det h�gsta djupet i det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return djupet.
	 */
	public int depth() {
		return -1;
	}

	/**
	 * Returnerar en str�ngrepresentation f�r det (sub)tr�d som noden utg�r root
	 * i. Denna representation best�r av elementens dataobjekt i sorterad
	 * ordning med ", " mellan elementen.
	 * 
	 * @return str�ngrepresentationen f�r det (sub)tr�d som noden utg�r root i.
	 */
	public String toString() {
		return "";
	}
}
