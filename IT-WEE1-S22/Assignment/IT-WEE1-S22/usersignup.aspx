<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="usersignup.aspx.cs" Inherits="usersignup" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">

    <div class="container">
        <div class="row">
            <div class="col-md-8 mx-auto">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                            <center>
                                <img src="images/generaluser.png" width="100px" />
                            </center>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                            <center>
                                <h4>Member Sign Up</h4>
                            </center>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col">
                            <center>
                                <hr>
                            </center>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Full name</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="MemberID" CssClass="form-control" ID="TextBox1" runat="server"></asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label>Date of birth ID</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="MemberID" CssClass="form-control" ID="TextBox2" runat="server" TextMode="Date"></asp:TextBox>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>Contact number</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="Contact number" CssClass="form-control" ID="TextBox3" runat="server" TextMode="Number"></asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label>Email ID</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="Email ID" CssClass="form-control" ID="TextBox4" runat="server" TextMode="Email"></asp:TextBox>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-4">
                                <label>State</label>
                                <div class="form-group">
                                    <asp:DropDownList class="form-control" ID="DropDownList1" runat="server">
                                        <asp:ListItem Text="Select" Value="select" />
                                        <asp:ListItem Text="Spain" Value="Spain" />
                                        <asp:ListItem Text="Denmark" Value="Denmark" />
                                        <asp:ListItem Text="Bolivia" Value="Bolivia" />
                                    </asp:DropDownList>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label>City</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="City" CssClass="form-control" ID="TextBox5" runat="server"></asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label>Pin code</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="Pin code" CssClass="form-control" ID="TextBox6" runat="server" TextMode="Number"></asp:TextBox>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <label>Full address</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="Full adress" CssClass="form-control" ID="TextBox7" runat="server" TextMode="MultiLine"></asp:TextBox>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col">
                                <center>
                                <span class="badge badge-pill badge-info">Login credentials</span>
                                </center>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <label>User ID</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="UserID" class="form-control" ID="TextBox8" runat="server"></asp:TextBox>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label>Password</label>
                                <div class="form-group">
                                    <asp:TextBox placeholder="Password" class="form-control" ID="TextBox9" runat="server" TextMode="SingleLine"></asp:TextBox>
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <asp:Button class="btn btn-success btn-block btn-lg" ID="Button1" runat="server" Text="Sign Up" OnClick="Button1_Click" />
                        </div>

                    </div>
                </div>
                <a href="homepage.aspx"><< Back home <br/> 
           
                <br /></a>
            </div>


        </div>
    </div>

</asp:Content>

