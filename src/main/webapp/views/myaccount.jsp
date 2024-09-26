<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!DOCTYPE html>
<html lang="en">
<body>

<div class="main">
<div class="container">

		<!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1>Update Info</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form action="/webprchieu5/myaccount" method="post" class="form-horizontal form-without-legend" role="form">
                  	<c:if test="${alert !=null}">
						<h3 class="alert alert danger">${alert}</h3>
					</c:if>
                    <div class="form-group">
                      <label for="username" class="col-lg-4 control-label">Username<span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="username" name="username" value="${sessionScope.account.username}" readonly>
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="password" class="form-control" id="password" name="password" value="${sessionScope.account.password}" readonly>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="fullname" class="col-lg-4 control-label">Fullname <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="fullname" name="fullname" value="${sessionScope.account.fullname}">
                      </div>
                    </div>
                    
<!--                     <div class="form-group"> -->
<!--                       <label for="image" class="col-lg-4 control-label">Image <span class="require">*</span></label> -->
<!--                       <form method="post" action="/webprchieu5/multiPartServlet" enctype="multipart/form-data"> -->
<!-- 						<input type="file" name="multiPartServlet"/> -->
<!-- 						<input type="submit" value="Upload"/> -->
<!-- 						</form> -->
<!--                     </div> -->
                    
                    <div class="form-group">
                      <label for="email" class="col-lg-4 control-label">Email<span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="email" name="email" value="${sessionScope.account.email}">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="phone" class="col-lg-4 control-label">Phone <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="phone" name="phone" value="${sessionScope.user.phone}">
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="role" class="col-lg-4 control-label">Role <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="role" name="role" value="${sessionScope.account.roleid}" readonly>
                      </div>
                    </div>
                    
                    <div class="form-group">
                      <label for="createddate" class="col-lg-4 control-label">Createddate <span class="require">*</span></label>
                      <div class="col-lg-8">
                        <input type="text" class="form-control" id="createddate" name="createddate" value="${sessionScope.account.createddate}" readonly>
                      </div>
                    </div>
                    
<!-- 					<div class="row"> -->
<!--                       <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20"> -->
<!--                         <button type="submit" class="btn btn-default">Cancel</button> -->
<!--                       </div> -->
<!--                     </div> -->

                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                        <button type="submit" class="btn btn-primary">Update</button>
                      </div>
                    </div>

                  </form>
                </div>
                <div class="col-md-4 col-sm-4 pull-right">
                  <div class="form-info">
                    <h2><em>Important</em> Information</h2>
                    <p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

                    <button type="button" class="btn btn-default">More details</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
          </div>
          <br></br>
</div>
</body>
</html>