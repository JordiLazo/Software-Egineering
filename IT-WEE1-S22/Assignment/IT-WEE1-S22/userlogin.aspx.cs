using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class userlogin : System.Web.UI.Page
{
    string strcon = ConfigurationManager.ConnectionStrings["con"].ConnectionString;

    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {

        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == System.Data.ConnectionState.Closed){
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("SELECT * FROM member_master WHERE member_id='"+TextBox1.Text.Trim()+"' AND password='"+TextBox2.Text.Trim() +"';", con);
            SqlDataReader dr = cmd.ExecuteReader();

            if (dr.HasRows)
            {

                while (dr.Read())
                {

                    Response.Write("<script> alert ('Hi: "+dr.GetValue(8).ToString()+'\n'+"log in successfull');</script>");
                    Session["username"] = dr.GetValue(8).ToString();
                    Session["full name"] = dr.GetValue(0).ToString();
                    Session["role"] = "user";
                    Session["status"] = dr.GetValue(10).ToString();
                }

                Response.Redirect("homepage.aspx");
            }
            else {
                Response.Write("<script> alert ('Invalid credentials');</script>");
            }

        }
        catch (Exception ex)
        {
        }




        // Response.Write("<script> alert ('Sign Up Successful. Go to Log in');</script>");
    }
}