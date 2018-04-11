package override;

public class Select implements Sqlable{
	private String[] mColumns;
	private boolean mDistinct = false;
	private boolean mAll = false;


	@Override
	public String toSql() {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT ");

		if (mDistinct) {
			sql.append("DISTINCT ");
		}
		else if (mAll) {
			sql.append("ALL ");
		}

		if (mColumns != null && mColumns.length > 0) {
//			sql.append(TextUtils.join(", ", mColumns) + " ");
		}
		else {
			sql.append("* ");
		}

		return sql.toString();
	}

}
