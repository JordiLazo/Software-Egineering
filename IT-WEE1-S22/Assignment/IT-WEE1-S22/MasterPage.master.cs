using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class MasterPage : System.Web.UI.MasterPage
{
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            if (Session["role"].Equals(""))
            {
                LinkButton1.Visible = true; // user login button
                LinkButton2.Visible = true; // singup button

                LinkButton3.Visible = false; // logout button
                LinkButton5.Visible = false; // hello button

                LinkButton6.Visible = true; // admin button

                LinkButton11.Visible = false; // admin button
                LinkButton12.Visible = false; // admin button
                LinkButton8.Visible = false; // admin button
                LinkButton9.Visible = false; // admin button
                LinkButton10.Visible = false; // admin button
            }
            else if (Session["role"].Equals("user")) {

                LinkButton1.Visible = false; // user login button
                LinkButton2.Visible = false; // singup button

                LinkButton3.Visible = true; // logout button
                LinkButton5.Visible = true; // hello button
                LinkButton5.Text = "Hello " +Session["username"].ToString(); // hello button

                LinkButton11.Visible = false; // admin button
                LinkButton12.Visible = false; // admin button
                LinkButton8.Visible = false; // admin button
                LinkButton9.Visible = false; // admin button
                LinkButton10.Visible = false; // admin button
            }
            else if (Session["role"].Equals("admin")) {
                LinkButton1.Visible = false; // user login button
                LinkButton2.Visible = false; // singup button

                LinkButton3.Visible = true; // logout button
                LinkButton5.Visible = true; // hello button
                LinkButton5.Text = "Hello admin "; // hello button

                LinkButton6.Visible = false; // admin button
                LinkButton11.Visible = true; // admin button
                LinkButton12.Visible = true; // admin button
                LinkButton8.Visible = true; // admin button
                LinkButton9.Visible = true; // admin button
                LinkButton10.Visible = true; // admin button
            }
        }
        catch (Exception ex) { 
        }


    }
    protected void LinkButton6_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminlogin.aspx");
    }
    protected void LinkButton11_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminauthormanagement.aspx");
    }
    protected void LinkButton12_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminpublishermanagement.aspx");
    }
    protected void LinkButton8_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminbookinventory.aspx");
    }
    protected void LinkButton9_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminbookissuing.aspx");
    }
    protected void LinkButton10_Click(object sender, EventArgs e)
    {
        Response.Redirect("adminmember.aspx");
    }
    protected void LinkButton4_Click(object sender, EventArgs e)
    {
        Response.Redirect("viewbooks.aspx");
    }
    protected void LinkButton1_Click(object sender, EventArgs e)
    {
        Response.Redirect("userlogin.aspx");
    }
    protected void LinkButton2_Click(object sender, EventArgs e)
    {
        Response.Redirect("usersignup.aspx");
    }
    protected void LinkButton3_Click(object sender, EventArgs e)
    {
        Session["username"] = "";
        Session["full name"] = "";
        Session["role"] = "";
        Session["status"] = "";

        LinkButton1.Visible = true; // user login button
        LinkButton2.Visible = true; // singup button

        LinkButton3.Visible = false; // logout button
        LinkButton5.Visible = false; // hello button

        LinkButton6.Visible = true; // admin button

        LinkButton11.Visible = false; // admin button
        LinkButton12.Visible = false; // admin button
        LinkButton8.Visible = false; // admin button
        LinkButton9.Visible = false; // admin button
        LinkButton10.Visible = false; // admin button
        Response.Redirect("homepage.aspx");
    }
    protected void LinkButton5_Click(object sender, EventArgs e)
    {
        Response.Redirect("userprofile.aspx");
    }
}
