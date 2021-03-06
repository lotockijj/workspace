; Script generated by the Inno Script Studio Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!


[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{A35F8B90-926A-4EF6-904C-C57D7C4FD174}
AppName={#_AppName}
AppVersion={#_AppVersion}
;AppVerName={#_AppName} {#_AppVersion}
AppPublisher={#_AppPublisher}
AppPublisherURL={#_AppURL}
AppSupportURL={#_AppURL}
AppUpdatesURL={#_AppURL}
DefaultDirName={pf}\{#_AppName}
DefaultGroupName={#_AppName}
Compression=lzma
SolidCompression=yes
DisableWelcomePage=no

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Dirs]
Name: {app}; Permissions: users-full
; Permissions: everyone-modify users-modify

[Files]
Source: "..\MindCastr\dist\MindCastr.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "..\MindCastr\dist\updater.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "..\MindCastr\dist\lib\*.jar"; DestDir: "{app}\lib\"; Flags: ignoreversion
Source: "..\MindCastr\src\osinfo"; DestDir: "{app}"; Flags: ignoreversion
Source: "..\MindCastr\src\default.properties"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{group}\{#_AppName}"; Filename: "{app}\{#_AppExeName}"
Name: "{commondesktop}\{#_AppName}"; Filename: "{app}\{#_AppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#_AppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(_AppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent

[UninstallDelete]
Type: files; Name: "{app}\mindcastr.single"
Type: filesandordirs; Name: "{app}\backup"
Type: filesandordirs; Name: "{app}"

[Code]
procedure DecodeVersion (verstr: String; var verint: array of Integer);
var
  i,p: Integer; s: string;
begin
  // initialize array
  verint := [0,0,0,0];
  i := 0;
  while ((Length(verstr) > 0) and (i < 4)) do
  begin
    p := pos ('.', verstr);
    if p > 0 then
    begin
      if p = 1 then s:= '0' else s:= Copy (verstr, 1, p - 1);
      verint[i] := StrToInt(s);
      i := i + 1;
      verstr := Copy (verstr, p+1, Length(verstr));
    end
    else
    begin
      verint[i] := StrToInt (verstr);
      verstr := '';
    end;
  end;

end;

function CompareVersion (ver1, ver2: String) : Integer;
var
  verint1, verint2: array of Integer;
  i: integer;
begin

  SetArrayLength (verint1, 4);
  DecodeVersion (ver1, verint1);

  SetArrayLength (verint2, 4);
  DecodeVersion (ver2, verint2);

  Result := 0; i := 0;
  while ((Result = 0) and ( i < 4 )) do
  begin
    if verint1[i] > verint2[i] then
      Result := 1
    else
      if verint1[i] < verint2[i] then
        Result := -1
      else
        Result := 0;
    i := i + 1;
  end;

end;

// Here's _ code
function InitializeSetup(): Boolean;
var
  ErrorCode: Integer;
  JavaVer : String;
  Result1 : Boolean;
begin
    RegQueryStringValue(HKLM, 'SOFTWARE\JavaSoft\Java Runtime Environment', 'CurrentVersion', JavaVer);
    Result := false;
    if Length( JavaVer ) > 0 then
    begin
    	if CompareVersion(JavaVer,'1.7') >= 0 then
    	begin
    		Result := true;
    	end;
    end;
    if Result = false then
    begin
    	Result1 := MsgBox('This tool requires Java Runtime Environment v1.6 or older to run. Please download and install JRE and run this setup again.' + #13 + #10 + 'Do you want to download it now?',
    	  mbConfirmation, MB_YESNO) = idYes;
    	if Result1 = true then
    	begin
    		ShellExec('open',
    		  'http://www.java.com/en/download/',
    		  '','',SW_SHOWNORMAL,ewNoWait,ErrorCode);
    	end;
    end;
end;

