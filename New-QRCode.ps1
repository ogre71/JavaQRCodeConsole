function New-QRCode{ 
	Param
    (
        # Param1 help description
        [Parameter(Mandatory=$true,
                   ValueFromPipelineByPropertyName=$true,
                   Position=0)]
        [string]$url,

		[Parameter(Mandatory=$true,
                   ValueFromPipelineByPropertyName=$false,
                   Position=1)]
        [string]$filename
    )
	process {
		get-location | Set-Variable oldLocation
		push-location 
		set-location C:\Users\ogre7\scratch\20201107\java1\thisIsTheArtifactId
		mvn exec:java -D exec.mainClass=thisIsTheGroupId.App -D exec.arguments="$url,$oldLocation/$filename"
		Pop-Location
	}

}
