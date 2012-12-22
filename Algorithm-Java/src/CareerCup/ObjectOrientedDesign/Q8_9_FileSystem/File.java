/**
 * Sanqiang Zhao Www.131X.Com Dec 19, 2012
 */
package CareerCup.ObjectOrientedDesign.Q8_9_FileSystem;

public class File extends Entry {

    public String content;
    public int size;

    public File(String _name, Directory _parent, String _content) {
        super(_name, _parent);
        this.content = _content;
        this.size = _content.length();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void delete() {
        parent.files.remove(this);
        this.remove = true;
    }

    public static void main(String[] args) {
    }
}
