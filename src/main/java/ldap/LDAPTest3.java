package ldap;import org.owasp.encoder.Encode;import javax.naming.NamingEnumeration;import javax.naming.NamingException;import javax.naming.directory.SearchControls;import javax.naming.directory.SearchResult;import javax.naming.directory.DirContext;public class LDAPTest3 {  public boolean test(String user, String pass, DirContext ctx) throws NamingException {    String userUnsafe = null;    userUnsafe = user;    user = "{1}" + "_USER";    String filter = "(&(uid=" + user + ")(userPassword=" + "{0}" + "))";    NamingEnumeration<SearchResult> results =        ctx.search("ou=system", filter, new String[] {pass, userUnsafe}, new SearchControls());    return results.hasMore();  }}