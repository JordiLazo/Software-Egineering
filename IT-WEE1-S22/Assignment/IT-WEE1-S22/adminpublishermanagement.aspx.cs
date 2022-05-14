using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class adminpublishermanagement : System.Web.UI.Page
{
    string strcon = ConfigurationManager.ConnectionStrings["con"].ConnectionString;

    protected void Page_Load(object sender, EventArgs e)
    {

    }
    //add button
    protected void Button2_Click(object sender, EventArgs e)
    {
        if (checkAuthorId())
        {
            Response.Write("<script> alert('publisher with this ID already exists');</script>");
        }
        else
        {
            addNewAuthor();
        }
    }

    //update button
    protected void Button3_Click(object sender, EventArgs e)
    {
        if (checkAuthorId())
        {
            updateAuthor();
        }
        else
        {
            Response.Write("<script> alert('publisher does not exists');</script>");
        }
    }


    //delete button
    protected void Button4_Click(object sender, EventArgs e)
    {
        if (checkAuthorId())
        {
            deleteAuthor();
        }
        else
        {
            Response.Write("<script> alert('publisher does not exists');</script>");
        }
    }

    //go button
    protected void Button1_Click(object sender, EventArgs e)
    {
        getAuthorName();
    }

    //user define function
    void getAuthorName()
    {

        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("SELECT * FROM publisher_name WHERE publisher_id='" + TextBox3.Text.Trim() + "';", con);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);

            if (dt.Rows.Count >= 1)
            {
                TextBox4.Text = dt.Rows[0][1].ToString();
            }
            else
            {
                Response.Write("<script> alert ('Invalid publisher ID.');</script>");
            }
        }
        catch (Exception ex)
        {

            Response.Write("<script> alert('" + ex.Message + "');</script>");
        }
    }

    void clearForm()
    {
        TextBox3.Text = "";
        TextBox4.Text = "";
    }

    void deleteAuthor()
    {

        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("DELETE from publisher_name WHERE publisher_id='" + TextBox3.Text.Trim() + "'", con);

            cmd.Parameters.AddWithValue("@publisher_name", TextBox4.Text.Trim());

            cmd.ExecuteNonQuery();
            con.Close();
            Response.Write("<script> alert ('publisher deleted successfully.');</script>");
            clearForm();
            GridView1.DataBind();
        }
        catch (Exception ex)
        {

            Response.Write("<script> alert('" + ex.Message + "');</script>");
        }

    }

    void updateAuthor()
    {
        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("UPDATE publisher_name SET publisher_name=@publisher_name WHERE publisher_id='" + TextBox3.Text.Trim() + "'", con);

            cmd.Parameters.AddWithValue("@publisher_name", TextBox4.Text.Trim());

            cmd.ExecuteNonQuery();
            con.Close();
            Response.Write("<script> alert ('publisher updated successfully.');</script>");
            clearForm();
            GridView1.DataBind();

        }
        catch (Exception ex)
        {

            Response.Write("<script> alert('" + ex.Message + "');</script>");
        }
    }

    void addNewAuthor()
    {

        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("INSERT INTO publisher_name (publisher_id,publisher_name) values (@publisher_id,@publisher_name)", con);

            cmd.Parameters.AddWithValue("@publisher_id", TextBox3.Text.Trim());
            cmd.Parameters.AddWithValue("@publisher_name", TextBox4.Text.Trim());

            cmd.ExecuteNonQuery();
            con.Close();
            Response.Write("<script> alert ('publisher added successfully.');</script>");
            clearForm();
            GridView1.DataBind();
        }
        catch (Exception ex)
        {

            Response.Write("<script> alert('" + ex.Message + "');</script>");
        }
    }

    bool checkAuthorId()
    {

        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("SELECT * FROM publisher_name WHERE publisher_id='" + TextBox3.Text.Trim() + "';", con);
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);

            if (dt.Rows.Count >= 1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception ex)
        {

            Response.Write("<script> alert('" + ex.Message + "');</script>");
            return false;
        }
    }
    protected void TextBox3_TextChanged(object sender, EventArgs e)
    {

    }
}