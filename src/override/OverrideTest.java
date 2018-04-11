package override;

public class OverrideTest implements Sqlable{
	private final StringBuilder mWhere = new StringBuilder();
	private String mGroupBy;
	private String mHaving;
	private String mOrderBy;
	private String mLimit;
	private String mOffset;
	private String mAlias;

	@Override
	public String toSql() {
        final StringBuilder sql = new StringBuilder();
        addOffset(sql);
        return "";
	}

    private void addFrom(final StringBuilder sql) {
        sql.append("FROM ");

        if (mAlias != null) {
            sql.append("AS ");
            sql.append(mAlias);
            sql.append(" ");
        }
    }

    private void addOffset(final StringBuilder sql) {
        if (mOffset != null) {
            sql.append("OFFSET ");
            sql.append(mOffset);
            sql.append(" ");
        }
    }

}
