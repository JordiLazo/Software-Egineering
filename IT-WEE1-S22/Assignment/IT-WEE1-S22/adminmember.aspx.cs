using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

public partial class adminmemeber : System.Web.UI.Page
{
    string strcon = ConfigurationManager.ConnectionStrings["con"].ConnectionString;

    protected void Page_Load(object sender, EventArgs e)
    {
        GridView1.DataBind();
    }

    //green button
    protected void Button3_Click(object sender, EventArgs e)
    {
        updateMemberStatus("active");
    }

    //go button
    protected void Button1_Click(object sender, EventArgs e)
    {
        getMemeberByID();
    }

    //yellow button
    protected void LinkButton1_Click(object sender, EventArgs e)
    {
        updateMemberStatus("pending");

    }

    //red button
    protected void LinkButton2_Click(object sender, EventArgs e)
    {
        updateMemberStatus("deactivate");
    }

    //delete button
    protected void Button2_Click(object sender, EventArgs e)
    {
        deleteMemberById();
    }

    void clearForm(){

        TextBox4.Text = "";
        TextBox7.Text = "";
        TextBox8.Text = "";
        TextBox1.Text = "";
        TextBox2.Text = "";
        TextBox5.Text = "";
        TextBox6.Text = "";
        TextBox9.Text = "";
        TextBox10.Text = "";
    
    }

    void deleteMemberById() {

        if (TextBox3.Text.Trim().Equals(""))
        {
            Response.Write("<script> alert ('Member ID can not be blank.');</script>");
        }
        else
        {

            try
            {
                SqlConnection con = new SqlConnection(strcon);
                if (con.State == ConnectionState.Closed)
                {
                    con.Open();
                }

                SqlCommand cmd = new SqlCommand("DELETE from member_master WHERE member_id='" + TextBox3.Text.Trim() + "'", con);

                cmd.ExecuteNonQuery();
                con.Close();
                Response.Write("<script> alert ('Member deleted successfully.');</script>");
                clearForm();
                GridView1.DataBind();
            }
            catch (Exception ex)
            {

                Response.Write("<script> alert('" + ex.Message + "');</script>");
            }
        }
    
    }

    void updateMemberStatus(String status) {

        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == System.Data.ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("UPDATE member_master SET account_status='"+status+"' WHERE member_id='" + TextBox3.Text.Trim() + "'", con);
            cmd.ExecuteNonQuery();
            con.Close();
            GridView1.DataBind();
            Response.Write("<script> alert ('Member status updated');</script>");

        }
        catch (Exception ex)
        {
            Response.Write("<script> alert ('" + ex.Message + "');</script>");
        }

    }

    void getMemeberByID() {
        try
        {
            SqlConnection con = new SqlConnection(strcon);
            if (con.State == System.Data.ConnectionState.Closed)
            {
                con.Open();
            }

            SqlCommand cmd = new SqlCommand("SELECT * FROM member_master WHERE member_id='" + TextBox3.Text.Trim()+"'", con);
            SqlDataReader dr = cmd.ExecuteReader();

            if (dr.HasRows)
            {

                while (dr.Read())
                {
                    TextBox4.Text = dr.GetValue(0).ToString();
                    TextBox7.Text = dr.GetValue(10).ToString();
                    TextBox8.Text = dr.GetValue(1).ToString();
                    TextBox1.Text = dr.GetValue(2).ToString();
                    TextBox2.Text = dr.GetValue(3).ToString();
                    TextBox5.Text = dr.GetValue(4).ToString();
                    TextBox6.Text = dr.GetValue(5).ToString();
                    TextBox9.Text = dr.GetValue(6).ToString();
                    TextBox10.Text = dr.GetValue(7).ToString();

                }
            }
            else
            {
                Response.Write("<script> alert ('Invalid credentials');</script>");
            }

        }
        catch (Exception ex)
        {
            Response.Write("<script> alert ('" + ex.Message + "');</script>");
        }
    }
}