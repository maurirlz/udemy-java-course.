package InnerAndAbstractrClassesAndInterfaces.InnerClasses;

public class Button {

    private String title;
    private OnClickListener onClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(OnClickListener OnClickListener) {

        this.onClickListener = onClickListener;
    }

    public void onClick() {

        this.onClickListener.OnClick(this.title);
    }

    public interface OnClickListener {

        public void OnClick(String title);
    }
}
